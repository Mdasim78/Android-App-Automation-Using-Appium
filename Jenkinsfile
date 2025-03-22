// node {
//   stage('SCM') {
//     checkout scm
//   }
//   stage('SonarQube Analysis') {
//     def mvn = tool 'Maven';
//     withSonarQubeEnv('SonarQube-Server') {
//       sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=Mdasim78_Android-App-Automation-Using-Appium_16c443fb-d6cc-4c98-8cde-356ec465e9dd -Dsonar.projectName='Android-App-Automation-Using-Appium'"
//     }
//   }
// }

//////////////// scripted pipeline//////////////////
pipeline {
    agent any
   
    stages {
        stage('Build') {
            steps {
                def Maven = tool 'Maven'
                bat "Maven/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=Mdasim78_Android-App-Automation-Using-Appium_16c443fb-d6cc-4c98-8cde-356ec465e9dd -Dsonar.projectName='Android-App-Automation-Using-Appium'"
                echo 'Building..'
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

