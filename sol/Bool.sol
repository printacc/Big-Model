// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;
contract Boold{
    bool _a;
    function getBool()public  view   returns (bool){
        return _a;
    }

    // function pay() public  payable {
    //    payable(address(this)).transfer(msg.value);
    // }
    fallback ()external payable {

    }
    function getapy() public view   returns (uint){
        return address(this).balance;
    }

    function thang() public  payable {
        //  address add = 0x4B20993Bc481177ec7E8f571ceCaE8A9e22C02db;
        // //payable(add).transfer(msg.value);
        // payable(add).transfer(10 ether);
        address payable add = payable(0x4B20993Bc481177ec7E8f571ceCaE8A9e22C02db);
        add.transfer(10 ether);
    }
    receive() external payable {
        
    }
    
}