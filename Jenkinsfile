pipeline {
    // master executor should be set to 0
    agent any
    stages {

        stage('Build Jar') {
//                      agent {
//                          docker {
//                              image 'maven:3-alpine'
//                             // args '-v $HOME/.m2:/root/.m2'
//                          }
//                      }
                     steps {
                         sh 'mvn clean package -DskipTests'
                     }
                 }
      stage('Pull Images') {
            steps {
                    //sh
                    sh '''
                    docker pull seleniarm/hub:4.1.2-20220227
                    docker pull seleniarm/node-chromium:4.1.2-20220227
                    docker pull seleniarm/node-firefox:4.1.2-20220227 '''
            }
      }
      stage('Run Docker-Compose Up') {
            steps {
                   sh 'docker-compose up -d'
                   sh 'java -cp "/Users/sangram.das/GIT/POMUIAutomation/target/selenium-docker-tests.jar:/Users/sangram.das/GIT/POMUIAutomation/target/libs/*" org.testng.TestNG "/Users/sangram.das/GIT/POMUIAutomation/testng.xml"'
            }
      }

      stage('Run Docker-Compose Down') {
            steps {
                   sh 'docker-compose down'
            }
      }
    }
}