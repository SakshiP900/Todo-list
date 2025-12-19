pipeline {
    agent any

    tools {
        jdk 'OpenJDK21'
        maven 'jenkins-maven'
    }

    environment {
        IMAGE_NAME = 'todo-list-app'
        CONTAINER_NAME = 'todo-list-container'
    }

    stages {

        stage('Checkout Source') {
            steps {
                git branch: 'main', url: 'https://github.com/SakshiP900/Todo-list.git'
            }
        }

        stage('Build WAR with Maven') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %IMAGE_NAME% .'
            }
        }

        stage('Stop Old Container') {
            steps {
                bat '''
                docker stop %CONTAINER_NAME% || exit 0
                docker rm %CONTAINER_NAME% || exit 0
                '''
            }
        }

        stage('Run Container') {
            steps {
                bat '''
                docker run -d ^
                --name %CONTAINER_NAME% ^
                -p 3000:8080 ^
                %IMAGE_NAME%
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Application deployed successfully on port 3000'
        }
        failure {
            echo '❌ Build or deployment failed'
        }
    }
}

