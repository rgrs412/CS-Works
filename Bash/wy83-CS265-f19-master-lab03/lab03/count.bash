#!/bin/bash
numOfFiles=$( ls -1 | wc -l )
for (( i=1; i<$numOfFiles + 1; ++i )) ; do
	fileName=$( ls -1 | head -"$i" | tail -1 ) 
	if [[ -f $fileName ]] ; then
	echo $fileName \
	$( cat "$fileName" | wc -l ; cat "$fileName" | wc -w ; )
   fi 
done
exit 0
