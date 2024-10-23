; Program Description: A program that goes through an array, adds the value of shift to each element, and stores
; each value in its correct registers.
; Author: JB McAllister
; Creation Date: 10/03/2024

.386

.model flat, stdcall

.stack 4096

ExitProcess proto, dwExitCode:word

.data

array DWORD 1, 2, 3

 

.code

main proc

mov eax, [array]; copy the first value into EAX

xchg EAX, [array + 4]; exchange EAX with the value in the second position

xchg eax, [array + 8]; exchange EAX with the value in the third position

mov [array], eax; copy the value in EAX to the first position of the array

invoke ExitProcess,0

main endp

end main