pipeline {
    agent any
    tools {
        maven 'maven3.9'
    }
    stages {
        stage('build jar') {
            steps {
                script{
                    echo "Building application"
                    sh 'mvn package'
                }
                
            }
         }

       stage('build image'){
            steps{
                script{
                    echo "building image"
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable:'USER')]) {
                        sh 'docker build -t dukaegbu/dbase-repo:Jma-2.0 .'
                        sh 'echo "mypassword" | docker login -u "myusername" --password-stdin'
                        sh ' docker push dukaegbu/dbase-repo:Jma-2.0'
                    }
                }
            }
       }
       stage('deploy') {
            steps {
                script{
                    echo "deploying application"
                }
                
            }
         } 
    }     
 }
