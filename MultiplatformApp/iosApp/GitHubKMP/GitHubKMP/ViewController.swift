/

import UIKit
import shared

class ViewController: UIViewController {

  @IBOutlet weak var greeting: UILabel!
  
  override func viewDidLoad() {
    super.viewDidLoad()
    // Do any additional setup after loading the view, typically from a nib.
    
    greeting.text =  Greeting().greeting()
  }

}

