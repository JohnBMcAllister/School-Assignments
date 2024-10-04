; Program Description: A program that goes through an array, adds the value of shift to each element, and stores each value in its correct registers.
; Author: JB McAllister
; Creation Date: 10/03/2024

.386
.model flat, stdcall
.stack 4096
ExitProcess PROTO, dwExitCode:DWORD

.data
input BYTE 1, 2, 3, 4, 5, 6, 7, 8 ; input array of type byte
shift BYTE 2                       ; shift value of type byte

.code
main proc
		
		sub eax, eax			  ; clears eax register
		sub ebx, ebx			  ; clears ebx register
		sub ecx, ecx			  ; clears ecx register
		sub edx, edx			  ; clears edx register

		mov ah, input[0]		  ; moves first element to high position of AX
		add ah, shift			  ; add shift value
		mov al, input[1]		  ; moves second element to low position of AX
		add al, shift			  ; add shift value

		mov bh, input[2]		  ; moves third element to high position of BX
		add bh, shift			  ; add shift value
		mov bl, input[3]		  ; moves fourth element to low position of BX
		add bl, shift			  ; add shift value

		mov ch, input[4]		  ; moves fith element to high position of CX
		add ch, shift			  ; add shift value
		mov cl, input[5]		  ; moves sixth value to low position of CX
		add cl, shift			  ; add shift value

		mov dh, input[6]		  ; moves seventh element to high position of DX
		add dh, shift			  ; add shift value
		mov dl, input[7]		  ; moves final element to low position of DX
		add dl, shift			  ; add shift value

		invoke ExitProcess, 0	  ; exit the program
	main endp
END main
