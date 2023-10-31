// SPDX-License-Identifier: MIT
pragma solidity ^0.8.8;
contract chongzaiTest{
    uint public  a;
    function demo1(uint _a)public {
        a=123;
    }
    function demo1(string memory inp)public {
        
        a=334532;
    }
    function texe()public {
        demo1(1111);
    }
}