# How To boot up This Project
1. Enter the folder that contain the ***pom.xml*** and in the command line run "mvn package"
2. In The parent folder there will be Folder called **Deployment**
3. Enter The **Deployment** folder until you reach the Folder that contain the ***Dockerfile***
4. In the command Line run "docker image build -t validation"
5. Then run docker ***"docker container run -p 8013:8013 validation"***
6. In your browser enter http://localhost:8013/phone-validator/api/regex/phoneNumbers
