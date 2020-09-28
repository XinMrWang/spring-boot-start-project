# startProject
    脚手架
    
# maven打包构建部署
    垂直分层时: mvn clean package -am -Pdev -Dmaven.test.skip=true
    平行分层时: mvn clean package -am -pl xx指定某个包xxx -Pdev -Dmaven.test.skip=true
    cd xx项目名xx/target
    mvn -f docker-pom.xml -DskipTests=true docker:stop docker:remove docker:build docker:start
