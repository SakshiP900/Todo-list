pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the main branch from GitHub
                git branch: 'main', url: 'https://github.com/SakshiP900/Todo-list.git'
            }
        }

        stage('Build') {
            steps {
                // Linux shell command for Maven build
                sh 'mvn clean package'
            }
        }

        stage('Docker Build & Run') {
            steps {
                // Build Docker image
                sh 'docker build -t todo-app:latest .'
                
                // Stop container if running (won't fail if it doesn't exist)
                sh 'docker stop todo-app || true'
                
                // Remove container if exists (won't fail if it doesn't exist)
                sh 'docker rm todo-app || true'
                
                // Run container on port 3000
                sh 'docker run -d -p 3000:3000 --name todo-app todo-app:latest'
            }
        }
    }
}
