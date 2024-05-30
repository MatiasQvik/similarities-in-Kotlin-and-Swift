//
//  SecondView.swift
//  SwiftExample
//
//  Created by Matias Hätönen on 6.5.2024.
//

import Foundation
import SwiftUI

struct SecondView: View {
    var name: String
    
    var goBack: () -> Void
    var body: some View {
        VStack {
            Text("second")
            Button("Back") {
                goBack()
            }
        }
    }
}
