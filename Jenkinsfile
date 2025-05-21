def build

pipeline {
    agent any
    environment {
        New
    }
    stages {
        stage('init') {
            steps {
                scripts {
                    gv = load "script.groovy"
                }
            }
        }
        stage('build') {
            steps {
                scripts {
                    gv.buildApp()
                }
            }
        }
        stage('test') {
            steps {
                scripts {
                    gv.testApp()
                }
            }
        }
        stage('deploy') {
            steps {
                scripts {
                    gv.deployApp()
                }
            }
        }
    }
}