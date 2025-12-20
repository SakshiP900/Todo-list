pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/SakshiP900/Todo-list.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build & Deploy') {
            steps {
                bat '''
                docker build -t todo-app:latest .

                docker stop todo-app || exit /b 0
                docker rm todo-app || exit /b 0

                docker run -d ^
                  --name todo-app ^
                  --restart unless-stopped ^
                  -p 3000:3000 ^
                  todo-app:latest
                '''
            }
        }
    }
}
