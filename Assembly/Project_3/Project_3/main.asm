.386
.model flat, stdcall
.stack 4096
ExitProcess proto, dwExitCode:word

.data
input BYTE 8, 7, 6, 5, 4, 3, 2, 1	;an input array of 8 elements with values 1 to 8
output BYTE 8 DUP(?)	;an output array of the same length as input
shift DWORD 3	;a shift variable

; Required (Needs to updated when testing other function): length of the input array
array_length DWORD 8	;length of the input array

.code
main proc
	; Initilazing the registers to prepare for shift loop
	sub eax, eax		; Clear eax
	sub ebx, ebx		; Clear ebx
	sub ecx, ecx		; Clear ecx
	sub edx, edx		; Clear edx

	; Load values into registers
	mov ebx, 0		; Set input index to 0
	mov ecx, array_length	; Set ecx to the length of the array

; Loop for creating output array with shifted values
shift_loop:
	; Reset the registers
	mov edx, shift	; Load shift into edx

	; Calculate the new index for the output arrary
	mov eax, ebx	; Load the input index into eax
	add eax, edx	; Add the shift to the input index
	sub edx, edx	; Clear edx
	div array_length		; Divide the sum by the array length
	mov eax, edx	; Load the remainder into eax
	mov dl, input[ebx]	; Load the value at the new index into dl
	mov output[eax], dl	; Store the value in the output array
	inc ebx		; Increment the input index
	loop shift_loop	; Loop until ecx = 0

	invoke ExitProcess,0	; Exit the program
main ENDP

END main