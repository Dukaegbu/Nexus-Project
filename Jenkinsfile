/* groovylint-disable-next-line CompileStatic */
pipeline {
    agent any

    tools {
        maven 'maven3.9'
    }
    stages {
        stage('build jar') {
            steps {
                script{
                    echo 'Building application'
                    sh 'mvn package'
                }
            }
         }

       stage('build image'){
            steps{
                script{
                    echo 'building image'
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'DOCKER_PASS', usernameVariable:'DOCKER_USER')]) {
                        sh '''
                            echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                            docker build -t dukaegbu/dbase-repo:jma-2.0 .
                            docker push dukaegbu/dbase-repo:jma-2.0
                        '''
                    }
                }
            }
       }
       stage('deploy') {
            steps {
                script{
                    echo 'deploying application'
                }
            }
         }
    }
 }
