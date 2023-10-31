// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;
contract stor{
    uint[] public  arr;
    function set(uint[] memory _nadd)public {
        arr=_nadd;
        uint[] memory nacc=new uint[](arr.length);
        nacc=arr;
        for (uint a=0;a<nacc.length;a++){
            nacc[a]=a+2;
        }
    }
    function getstor() public  view  returns(uint[] memory){
        return arr;
    }
}