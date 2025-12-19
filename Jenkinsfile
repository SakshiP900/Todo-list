pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/SakshiP900/Todo-list.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build & Run') {
            steps {
                sh 'docker build -t todo-app:latest .'
                sh 'docker stop todo-app || true'
                sh 'docker rm todo-app || true'
                sh 'docker run -d -p 3000:3000 --name todo-app todo-app:latest'
            }
        }
    }
}

