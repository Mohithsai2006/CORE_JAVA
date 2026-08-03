package D10_Collections.SetInterface.EnumSet;
import java.util.EnumSet;
enum Permission {
    READ,
    WRITE,
    UPDATE,
    DELETE,
    EXECUTE
}
public class Demo2 {
    public static void main(String[] args) {
        /*
         * EnumSet internally stores
         * bits instead of Nodes.
         *
         * Ordinals
         *
         * READ      ->0
         * WRITE     ->1
         * UPDATE    ->2
         * DELETE    ->3
         * EXECUTE   ->4
         */

        EnumSet<Permission> permissions =
                EnumSet.noneOf(Permission.class);

        /*
         * Initial bits
         *
         * 00000
         */

        permissions.add(Permission.READ);

        /*
         * Bit representation
         *
         * 00001
         */

        permissions.add(Permission.UPDATE);

        /*
         * 00101
         */

        permissions.add(Permission.EXECUTE);

        /*
         * 10101
         */

        System.out.println(permissions);

        System.out.println();

        /*
         * Duplicate
         *
         * Bit already 1.
         *
         * No change.
         */

        permissions.add(Permission.READ);

        System.out.println(permissions);

        System.out.println();

        /*
         * contains()
         *
         * Internally performs
         * bit checking.
         */

        System.out.println(
                permissions.contains(
                        Permission.UPDATE
                )
        );

        System.out.println();

        /*
         * Remove
         *
         * Bit becomes 0.
         */

        permissions.remove(
                Permission.UPDATE
        );

        /*
         * Now
         *
         * 10001
         */

        System.out.println(permissions);

        System.out.println();

        /*
         * Observe iteration.
         *
         * Even if inserted
         *
         * EXECUTE
         * READ
         * UPDATE
         *
         * Output follows
         * enum declaration order.
         */

        EnumSet<Permission> demo =
                EnumSet.of(

                        Permission.EXECUTE,

                        Permission.READ,

                        Permission.UPDATE

                );

        System.out.println(demo);

        /*
         * Output
         *
         * READ
         * UPDATE
         * EXECUTE
         */

    }

}
