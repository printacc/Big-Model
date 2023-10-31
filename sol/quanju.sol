// SPDX-License-Identifier: MIT
pragma solidity ^0.8.2;

contract quanju{
    function getmsg1() public view returns (address){
        return msg.sender;
    }
    function getmsg2() public view returns (bytes calldata){
        return msg.data;
    }
    function getmsg3() public view returns (bytes4){
        return msg.sig;
    }
    function getblack1() public view returns (uint){
        return block.number;
    }
    function getblack2() public view returns (uint){
        return block.gaslimit;
    }
    function getblack3() public view returns (uint){
        return block.difficulty;
    }
    function getblack4() public view returns (uint){
        return block.chainid;
    }
    function getblack5() public view returns (address){
        return block.coinbase;
    }

    
}