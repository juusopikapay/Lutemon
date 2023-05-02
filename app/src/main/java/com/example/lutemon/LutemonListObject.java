public class LutemonListObject : MonoBehaviour
{
    LutemonList list;
    [SerializeField] LutemonContainer container;

    void Start()
    {
        list = transform.parent.GetComponent<LutemonList>();
    }

    public void OnClick()
    {
        list.ListObjectClicked(container.Lutemon);
    }
}
