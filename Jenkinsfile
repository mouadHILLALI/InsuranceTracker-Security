pipeline {
    agent any
    environment {
        DOCKER_IMAGE = 'mouad22/insuranceTracker:latest'
        DOCKER_CREDENTIALS = 'docker-hub-credentials-id'
    }
    stages {
        stage('Build') {
            steps {
                echo "Building the application..."
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                echo "Running tests..."
                sh 'mvn test'
            }
        }
        stage('Deliver') {
            steps {
                echo "Building Docker image..."
                sh '''
                docker build -t $DOCKER_IMAGE .
                '''
                echo "Pushing Docker image to Docker Hub..."
                withDockerRegistry([credentialsId: "$DOCKER_CREDENTIALS", url: "https://index.docker.io/v1/"]) {
                    sh '''
                    docker push $DOCKER_IMAGE
                    '''
                }
            }
        }
    }
    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
