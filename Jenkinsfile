
////////////////declarative pipe-line//////////////////
pipeline {
    agent any
    
    triggers {
  		githubPush()
  		
	}
    
   	tools {
              maven 'Maven'
    }
    
            
    stages {
        stage('Build') {
	       environment {
	        SONAR_TOKEN = credentials('Appium-android-automation-token')
	    	}
            steps {
            	echo "testing trigger-build using poll SCM every 2 minutes from a remote device"
                echo 'Building project. Build Number is '+ currentBuild.number
                bat """ 
                	  mvn clean verify sonar:sonar ^
                	 -Dsonar.projectKey=Mdasim78_Android-App-Automation-Using-Appium_16c443fb-d6cc-4c98-8cde-356ec465e9dd ^ 
                  	 -Dsonar.projectName=Android-App-Automation-Using-Appium ^
                  	 
                 """
               	echo "sonarqube analysis completed"
            }
            
            post{
            	success{
            	 echo "Build stage completed successfully"
            	 }
            	 failure{
            	echo "build failure"
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


