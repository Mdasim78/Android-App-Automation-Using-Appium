
////////////////declarative pipe-line//////////////////
pipeline {
    agent any
   	tools {
              maven 'Maven'
    }
    environment {
        SONAR_TOKEN = credentials('jenkins-sonarqube-global-token')
    }
            
    stages {
        stage('Build') {
       
            steps {
                echo 'Building project. Build Number is '+ currentBuild.number
                bat """ 
                	  mvn clean verify sonar:sonar ^
                	 -Dsonar.projectKey=Mdasim78_Android-App-Automation-Using-Appium_16c443fb-d6cc-4c98-8cde-356ec465e9dd ^ 
                  	 -Dsonar.projectName=Android-App-Automation-Using-Appium ^
                  	 -Dsonar.login=%SONAR_TOKEN% 
                 """
               	echo "sonarqube analysis completed"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}

////////////declarative pipe-line///////////////////
// pipeline{
//     agent any
//     stages{
//         stage('Declarative pipeline'){
//             steps{
//                 echo "hello asim using declarative pipeline"
//             }
//         }
//     }
// }

