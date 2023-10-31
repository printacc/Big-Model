// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;
contract kali{
    uint public mony;
    address payable  owen;
    constructor(){
        owen=payable(msg.sender);
    }
    function setmond() public {
        mony+=11;
    }
    // function killl() external{
    //     if(msg.sender==owen){
            
    //         selfdestruct(owen);
    //     }
    // }
    function kill() external {
        require(msg.sender == owen, "Only the owner can kill this contract");
        selfdestruct(owen);
        
    }

   
}