// replacAll()사용을 위해 regex에 대한 이해 필요.
// https://rockdrumy.tistory.com/1064
// https://codechacha.com/ko/java-regex/ 참고.

class Solution {
    public String solution(String new_id) {
        String answer = "";
        answer = stage1(new_id);
        answer = stage2(answer);
        answer = stage3(answer);
        answer = stage4(answer);
        answer = stage5(answer);
        answer = stage6(answer);
        answer = stage7(answer);
        return answer;
    }
    private String stage1(String id) {
        return id.toLowerCase();
    }
    private String stage2(String id) {
        return id.replaceAll("[~!@#$%^&*()=+\\[{\\]}:?,<>/]", "");
    }
    private String stage3(String id) {
        return id.replaceAll("[.]+",".");
    }
    private String stage4(String id) {
        if(id.length()>=1 && id.charAt(0) == '.') {
            id = id.substring(1,id.length());
        }
        if(id.length()>=1 && id.charAt(id.length()-1) == '.') {
            id = id.substring(0,id.length()-1);
        }
        return id;
    }
    private String stage5(String id) {
        if(id.length()==0){
            return "a";
        }
        return id;
    }
    private String stage6(String id) {
        if(id.length()>=16){
            id = id.substring(0,15);
            if(id.charAt(id.length()-1) == '.') {
                id = id.substring(0,id.length()-1);
            }
        }
        return id;
    }
    private String stage7(String id) {
        StringBuilder sb = new StringBuilder(id);
        if(id.length()<=2) {
            while(sb.length()<3){
                sb.append(id.charAt(id.length()-1));
            }
        }
        return sb.toString();
    }
}