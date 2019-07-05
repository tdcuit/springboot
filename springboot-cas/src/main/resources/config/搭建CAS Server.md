#搭建CAS server服务
1 下载 https://github.com/apereo/cas-overlay-template/tree/5.2  download zip
   执行./build.sh package  然后放置生成的cas.war到D:\Program Files\apache-tomcat-8.5.41\webapps路径下
   启动服务 D:\Program Files\apache-tomcat-8.5.41\bin> .\startup.bat
   
2 文件：D:\Program Files\apache-tomcat-8.5.41\webapps\cas\WEB-INF\classes\services\HTTPSandIMAPS-10000001.json  
  修改："serviceId" : "^(https|imaps)://.*",  -->  "serviceId" : "^(https|http|imaps)://.*",
3 文件：D:\Program Files\apache-tomcat-8.5.41\webapps\cas\WEB-INF\classes\application.properties
  cas.tgc.secure=false, cas.serviceRegistry.initFromJson=true这两个配置必须加，
  一个是指不进行安全访问，因为没有使用https进行连接，后面是初始化services文件的，让改写后的文件生效。
  
PS： tomcat 管理控制台登陆
    追加覆盖 D:\Program Files\apache-tomcat-8.5.41\conf\tomcat-users.xml 
      <role rolename="tomcat"/>
      <role rolename="role1"/>
      <role rolename="admin-gui"/>
      <role rolename="manager-gui"/>
      <user username="tomcat" password="tomcat" roles="tomcat,admin-gui,manager-gui"/>
      <user username="both" password="both" roles="tomcat,role1,admin-gui"/>
      <user username="role1" password="role1" roles="role1"/> 