// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;
contract errortest{
    error nadd(uint a);
    function geterrord()public {
        revert nadd(1);
    }
}