//
//  NameRepository.swift
//  SwiftExample
//
//  Created by Matias Hätönen on 6.5.2024.
//

import Foundation
import ComposableArchitecture

class NameRepository {
    func getName() async throws -> String {
        try await Task.sleep(for: .seconds(1))
        return "New name"
    }
}

private enum NameRepositoryKey: DependencyKey {
    static let liveValue = NameRepository()
}

extension DependencyValues {
    var nameRepository: NameRepository {
        get { self[NameRepositoryKey.self] }
        set { self[NameRepositoryKey.self] = newValue }
    }
}
