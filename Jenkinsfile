pipeline {
    agent any

    stages {

        stage('Clone Repository') {
            steps {
                git 'https://github.com/GitVaishu/Employee-Management-System.git'
            }
        }

        stage('Set Up JDK') {
            steps {
                // Assuming JDK 17 is installed on the Jenkins agent
                env.JAVA_HOME = tool name: 'JDK 17', type: 'jdk'
                env.PATH = "${env.JAVA_HOME}/bin:${env.PATH}"
            }
        }

        stage('Clean') {
            steps {
                sh 'mvn clean'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
    }

    post {
        success {
            echo 'Build and Tests Passed ✅'
        }
        failure {
            echo 'Build Failed ❌'
        }
    }
}