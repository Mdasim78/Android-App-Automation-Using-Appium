// node {
//   stage('SCM') {
//     checkout scm
//   }
//   stage('SonarQube Analysis') {
//     def mvn = tool 'Maven';
//     withSonarQubeEnv() {
//       sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=Mdasim78_Android-App-Automation-Using-Appium_16c443fb-d6cc-4c98-8cde-356ec465e9dd -Dsonar.projectName='Android-App-Automation-Using-Appium'"
//     }
//   }
// }
node {
stage('SonarQube Analysis') {
    def mvn = tool 'Maven';

    withSonarQubeEnv('SonarQube-Server') {
        bat """
        "${mvn}\\bin\\mvn" clean verify sonar:sonar ^
        -Dsonar.projectKey=Mdasim78_Android-App-Automation-Using-Appium_16c443fb-d6cc-4c98-8cde-356ec465e9dd ^
        -Dsonar.projectName='Android-App-Automation-Using-Appium' ^
        -Dsonar.login=%Appium-android-automation-token%
        """
      }
    }
}
