pipeline {
    agent any

    triggers {
        cron('0 15 * * *')  // Ежедневно в 18:00 по Москве (15:00 UTC)
    }

    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Solvefi/MongoDB.git'
            }
        }
        
        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker-compose -f docker-compose.yml up -d --build'
                }
            }
        }

        stage('Stop Docker Containers') {
            steps {
                script {
                    sh 'docker-compose down'
                }
            }
        }
    }

    post {
        success {
            echo 'Build successful!'
        }

        failure {
            echo 'Build failed!'
        }
    }
}
