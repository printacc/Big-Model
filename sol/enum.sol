// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;
contract enumTest{
   enum gard{nadd,aacc,dddd,afaf}
   gard nabb=gard.afaf;
   uint adcc=uint256(gard.afaf);
   function get()public  view  returns(uint){
       return adcc;
   }
}