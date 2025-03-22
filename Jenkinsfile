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
node{
    stage('hello') {
        echo "hello asim"
    }
}

////////////declarative pipe-line///////////////////
pipeline{
    agent any
    stages{
        stage('Declarative pipeline'){
            steps{
                echo "hello asim using declarative pipeline"
            }
        }
    }
}


//////////////
// pipeline {
//     agent any

//     stages {
//         stage('Checkout') {
//             steps {
//                 git 'https://github.com/Mdasim78/Android-App-Automation-Using-Appium.git'
//             }
//         }

//         stage('SonarQube Analysis') {
            
//                 withSonarQubeEnv('SonarQube-Server') {
//                     steps {

//                     bat "Maven/bin/mvn clean verify sonar:sonar " +
//                         "-Dsonar.projectKey=Mdasim78_Android-App-Automation-Using-Appium_16c443fb-d6cc-4c98-8cde-356ec465e9dd " +
//                         "-Dsonar.projectName='Android-App-Automation-Using-Appium'" +
//                         "-Dsonar.login=%Appium-android-automation-token% "
//                 }
//             }
//         }
//     }
// }

