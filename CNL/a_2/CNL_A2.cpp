#include <bits/stdc++.h>

using namespace std;

void division(int temp[], int g[], int fs, int gs){
    for(int i=0;i<fs;i++){
        int j=0,k=i;
        if (temp[k]>=g[j]){
            for(j=0,k=i;j<gs;j++,k++){
                if((temp[k]==1 && g[j]==1) || (temp[k]==0 && g[j]==0))
                    temp[k]=0;
                else
                    temp[k]=1;
            }
        }
    }
}

int main(){
	cout<<" **CRC**\n";
    int i,j,k,l;
    int fs, f[20], gs, g[20], temp[20], tf[15], crc[15];
    cout<<"\nSize of data: ";
    cin>>fs;
    cout<<"data:";
    for(i=0;i<fs;i++)
        cin>>f[i];
 
    cout<<"\nkey size: ";
    cin>>gs;
    cout<<" Enter key:";
    for(i=0;i<gs;i++)
        cin>>g[i];
 
    cout<<"\n **Sender**";
    cout<<"\n Data: ";
    for(i=0;i<fs;i++)
        cout<<f[i];

    cout<<"\n Key: ";

    for(i=0;i<gs;i++)
        cout<<g[i];
        
    int rs=gs-1;
    cout<<"\nNo. 0's to be appended: "<<rs;
    for (i=fs;i<fs+rs;i++)
        f[i]=0;

    for(i=0;i<20;i++)
        temp[i]=f[i];

    cout<<"\nMessage after appending :";
    for(i=0; i<fs+rs;i++)
        cout<<temp[i];

    division(temp,g,fs,gs);
    
    for(i=0,j=fs;i<rs;i++,j++)
        crc[i]=temp[j];
 
    cout<<"\nCRC bits: ";
    for(i=0;i<rs;i++)
        cout<<crc[i];
 
    cout<<"\nTransmitted Frame: ";

    for(i=0;i<fs;i++)
        tf[i]=f[i];
        
    for(i=fs,j=0;i<fs+rs;i++,j++)
        tf[i]=crc[j];

    for(i=0;i<fs+rs;i++)
        cout<<tf[i];
    
    cout<<"\n\n**Receiver**";
    label:
    cout<<"\nReceived Frame: ";
    
 	for(i=0;i<fs+rs;i++)
        cin>>temp[i];
 	
    division(temp,g,fs,gs);
    
    cout<<"Remainder: ";
    int rrem[15];
    rrem[0]=1;
    for (i=fs,j=0;i<fs+rs;i++,j++)
        rrem[j]=temp[i];

    for(i=0;i<rs;i++)
        cout<<rrem[i];

    int flag=0;
    for(i=0;i<rs;i++){
        if(rrem[i]!=0)
            flag=1;
    }
 
    if(flag==0)
      cout<<"\n\nMessage transmitted from Sender to Receiver is correct";

    else{
        cout<<"\n\nMessage transmitted from Sender to Receiver contains ERROR!\n Re-transmit the data ";
        goto label;
   }
   
return 0;
}
