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
                // Windows batch command for Maven build
                bat 'mvn clean package'
            }
        }

        stage('Docker Build & Run') {
            steps {
                // Build Docker image
                bat 'docker build -t todo-app:latest .'
                
                // Stop container if running
                bat 'docker stop todo-app || echo Container not running'
                
                // Remove container if exists
                bat 'docker rm todo-app || echo Container not found'
                
                // Run container on port 3000
                bat 'docker run -d -p 3000:3000 --name todo-app todo-app:latest'
            }
        }
    }
}
