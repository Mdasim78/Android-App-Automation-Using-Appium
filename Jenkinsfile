
////////////////declarative pipe-line//////////////////
pipeline {
    agent any
   	tools {
              maven 'Maven'
    }
    
            
    stages {
        stage('Build') {
	       environment {
	        SONAR_TOKEN = credentials('Appium-android-automation-token')
	    	}
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
            
            post{
            	success{
            	 echo "Build stage completed successfully"
            	 }
            	 failure{
            	 mail to: skmohammedasim786@gmail.com, subject: 'The Pipeline failed :('
            	 }
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


