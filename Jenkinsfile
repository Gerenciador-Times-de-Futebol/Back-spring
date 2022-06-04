pipeline{
    agent any
    stages{
        stage("Derrubando Aplicação Antiga"){
            steps{
                sh "docker-compose down"
            }
        }
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