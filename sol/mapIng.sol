// SPDX-License-Identifier: MIT
pragma solidity ^0.8.2;
 
 contract mappingTest{
     mapping (address =>uint) idmaping;
     mapping (uint =>string) namemping;

     uint public sum;

     modifier one(){
         require(idmaping[msg.sender]==0);
         _;
     }

     function getname(string memory input)public one{
         if(idmaping[msg.sender]>0){
             uint  _set1=idmaping[msg.sender];
             namemping[_set1]=input;
         }else {
            address _addr = msg.sender;
            sum++;
            idmaping[_addr]=sum;
            namemping[sum]=input;
         }


        
     }

     function getbyname(address _addr)public view  returns(string memory){
         uint _id1=idmaping[_addr];
         return namemping[_id1];

     }
 }