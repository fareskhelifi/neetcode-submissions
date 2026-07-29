class Solution:

    def encode(self, strs: List[str]) -> str:
        if not strs:
            return ""
        encoded_string = ""
        for string in strs:
            encoded_string += string + "[$_$]"
        return encoded_string

    def decode(self, s: str) -> List[str]:
        if not s:
            return []
        decoded_string = s[:len(s) - 5]
        return decoded_string.split("[$_$]")
