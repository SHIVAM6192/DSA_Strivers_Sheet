import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/../"));
    }
    public static String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> st = new Stack<>();

        for(String comp : components){
            if (comp.equals("") || comp.equals(".")) {
                continue;
            }

            if(comp.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else {
                st.push(comp);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()){
            sb.insert(0, "/" + st.pop());
        }

        return sb.isEmpty() ? "/" : sb.toString();
    }
}
