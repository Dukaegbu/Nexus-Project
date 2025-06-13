#!/user/bin/env groovy
/* groovylint-disable-next-line CompileStatic */
@Library('jenkins-shared-library')
def gv

pipeline {
    agent any

    tools {
        maven 'maven-3.9'
    }

    stages {
        stage('init') {
            steps {
                script {
                    gv = load 'script.groovy'
                }
            }
        }

        stage(incremental version) {
            steps {
                script {
                    echo 'incrementing version'
                    sh '''
                        mvn build-helper:parse-version versions:set \
                        -DnewVersion=\\${parsedVersion.majorVersion}.\\${parsedVersion.minorVersion}.\\${parsedVersion.nextIncrementalVersion} \
                        versions:commit
                       '''
                    matcher = readfile('pom.xml') =~ '<version>(.+)</version>'
                    version = [0][1]
                    env.imagename = "$version-$BUILD_NUMBER"
                }
            }
        }

        stage('build jar') {

            steps {
                script {
                    buildJar()
                }
            // buildJar()
            // script {
            //     gv.buildApp()
            //     sh 'mvn package'
            // }
            }
        }

        stage('building image') {
            steps {
                // when {
                //     expression {
                //         BRANCH_NAME == 'main'
                //     }
                // }
                script {
                    // buildImage 'dukaegbu/dbase-repo:myapp-2.0'
                    buildImage()
                // gv.buildImage()
                // withCredentials([
                //     usernamePassword(
                //         credentialsId: 'dockerhub-creds',
                //         usernameVariable: 'USERNAME',
                //         passwordVariable: 'PASSWORD'
                //     )
                // ])
                // {
                //     sh 'docker build -t dukaegbu/dbase-repo:myapp-2.0 .'
                //     sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin'
                //     sh 'docker push dukaegbu/dbase-repo:myapp-2.0'
                // }
                }
            }
        }

        stage('test') {
            steps {
                script {
                    gv.testApp()
                }
            }
        }

        stage('deploy') {
            input {
                message 'select the env to deploy'
                ok 'Done'
                parameters {
                    choice(name: 'ENV', choices: ['dev', 'staging', 'prod'], description: '')
                }
            }
            steps {
                script {
                    gv.deployApp()
                    echo "Deploying to ${ENV}"
                }
            }
        }
    }
}
