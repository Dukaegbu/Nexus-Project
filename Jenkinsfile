pipeline {
    agent any
    tools {
        maven '3.9'
    }
    stages {
        stage('build') {
            steps {
                echo 'Building Hello World'
            }
        }
       stage('test') {
            steps {
                echo 'testing'
            }
        }
       stage('deploy') {
            steps {
                echo 'deploying'
            }
        }
    }
}
