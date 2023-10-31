// SPDX-License-Identifier: MIT
pragma solidity ^0.8.2;
contract getTest{
    uint public age=1;
    uint ags=112;
    mapping(uint=>string) public map;
    mapping (uint=>string) mad;
    mapping (uint=>mapping(uint=>mapping (uint=>string)))public nadd;
    constructor(){
        map[1]="yjl";
        nadd[2][3][44]=unicode"杨金龙";
    }
    function amap(uint key) external view  returns (string memory){
        return map[key];
    }
    function getags() public  view  returns (uint){
        return this.age();
    }

}