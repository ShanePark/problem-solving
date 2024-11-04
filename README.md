# 💻 Problem Solving

## Intro

This repository is history of my algorithm practice. PS is my favourite hobby so I always wanna do better, be
exceptional.

I'm a kind of beginner yet but I really enjoy it and love to share idea with others who are also interested in.

most of them are written in Java. more of Kotlin ones will be added in the future.

**Any feedback will be always appreciated.**

I use those websites to solve problems, mostly leetcode which I never forgot the daily ones.

- [Leetcode](https://leetcode.com/)

> https://leetcode.com/Shane-Park/

- [Programmers](https://programmers.co.kr/)
- [Baekjoon Online Judge](https://www.acmicpc.net)

## Leetcode ClassName Factory

> Requirement: JAVA 11+

```bash
# clone the repository
git clone git@github.com:ShanePark/problem-solving.git

# go to the directory
cd problem-solving

# add the alis
alias leet='bash $(pwd)/leet.sh'

# execute the alias
leet
```

That's it. now you copy the problem title and execute it. it'll automatically make and put proper class name into your
clipboard. You even don't need to copy the title. just execute it, it will find the title from leetcode inner API.

> ![image-20220706091505271](images/leet.png)

If you want it to be permanent, add the alias to your `.bashrc` or `.zshrc` file. But you need to change the path to
absolute path.

## PSH

> https://github.com/ShanePark/psh

I made small utility package to help PS. it converts String to array, list, etc.. and also has lots of tools for testing
the code especially for leetcode. check it out!
