import sys, os
import socket
import fcntl
import struct

# MyIP = get_ip_address('eth0')
hostname = socket.gethostname()    
MyIP = socket.gethostbyname(hostname) 
subnet = int(MyIP[8:9])

print(hostname, " : ",MyIP)
print("Subnet : ", subnet)

#print subnet
if subnet==6:
    print ("Subnet A.\nIP address: ", MyIP)
elif subnet==4:
    print ("Subnet B.\nIP address: ", MyIP)
elif subnet==3:
    print ("Subnet C.\nIP address: ", MyIP)
elif subnet==2:
    print ("Subnet D.\nIP address: ", MyIP)

option=32 # random number. Doesn't have any logic

while option!=0:
    option = int(input("\n1. Intra subnet\n2. Intersubnet\n0. EXIT\n\n"))
    if option==1:
        PING=MyIP[:10]
        PCNo=input("Enter PC no.: ")
        PING=PING+PCNo
        os.system("ping -c 2 "+PING)
    elif option==2:
        name=input("Enter subnet name : ")
        PCNo=input("Enter PC no.: ")
        PING=MyIP[:8]
        if name=="A":
            PING=PING+"6."
        elif name=="B":
            PING=PING+"4."
        elif name=="C":
            PING=PING+"3."
        elif name=="D":
            PING=PING+"2."
        PING=PING+PCNo
        os.system("ping -c 2 "+PING)
    elif option!=1 or option!=2:
        break