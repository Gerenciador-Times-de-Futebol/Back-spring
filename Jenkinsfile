pipeline{
    agent any
    stages{
        stage("Subindo Aplicação"){
            steps{
                sh "docker-compose up -d --build"
            }
        }
    }
    post{
        always{
            echo "========always========"
        }
        success{
            echo "========pipeline executed successfully ========"
        }
        failure{
            echo "========pipeline execution failed========"
        }
    }
}