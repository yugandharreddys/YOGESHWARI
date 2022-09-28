def call(ip,user,credId){
  {sshagent([credId]) {
  sh "scp -o StrictHostKeyChecking=no target/mahan*.war ${user}@${ip}:/opt/tomcat9/webapps"
   // stop tomcat
   sh "ssh ${user}@${ip} /opt/tomcat9/bin/shutdown.sh"
    // start tomcat
    sh "ssh ${user}@${ip} /opt/tomcat9/bin/startup.sh"
}
