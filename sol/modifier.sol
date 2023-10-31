// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;
contract mod{
    uint public  a;
    modifier set1(){
        a=1;
        _;
        a=2;
    }
    modifier set2(){
        a=3;
        _;
        a=4;
    }
    function geta() public set1 set2{
        a=123;//a=2看调试过程  a=1->a=3->a=123->a=4->a=2
    }
}