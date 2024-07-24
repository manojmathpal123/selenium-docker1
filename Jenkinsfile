pipeline{

  agent any


  stages{

         stage('stage-1'){
               steps{
                   echo "doing mvn cleaner"
                   echo "doing mvn package"
                   echo "doing mvn install"
                   echo "doing mvn test"


               }


         }

         stage('stage-2'){

         steps{
                  echo "building docker image"
                  echo "doing mvn "

         }



         }


         stage('stage-3'){
            steps{
             echo "doing mvn cleanernow"
            }

         }

  }
   post{
   always{
        echo "doing clean up"
   }

   }







}