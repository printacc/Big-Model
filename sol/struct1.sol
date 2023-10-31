//  SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;
contract structTest{
    struct   stu{
        uint ids;
        string names;
    }
    stu  abd;
    stu bad;
    function text(stu storage aac)internal {
        abd=aac;
        aac.ids=111;
        aac.names=unicode"杨金龙";
    }
    function getStu()public returns (stu memory){
        bad = stu(1122,"llladfadfaf");
        text(bad);
        return abd;
    }

}